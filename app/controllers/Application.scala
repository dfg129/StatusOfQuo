package controllers

import play.api._
import play.api.mvc._

import scala.concurrent._

import reactivemongo.api._
import reactivemongo.bson._

import play.modules.reactivemongo._
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.json.BSONFormats._

import play.api.libs.json._
import play.api.libs.iteratee._
import play.api.libs.concurrent._
import play.api.libs.concurrent.Execution.Implicits
import play.api.Play.current


object Application extends Controller with MongoController {
  
  def index = Action {
    Ok(views.html.index("The Status Of Quo"))
  }

  def collection: JSONCollection = db.collection[JSONCollection]("articles")


  def create(name: String, index: Int) = Action.async {
  		val json = Json.obj(
  			"name" -> name,
  			"index" -> index,
  			"created" -> new java.util.Date().getTime())

  		collection.insert(json).map(lastError => Ok("Mongo LastError: %s".format(lastError)))
  }

  def findArticles() = Action.async {
   
  	val query = BSONDocument(
        "$query" -> BSONDocument("name" -> BSONRegex("^A", "")))

  	val cursor: Cursor[JsObject] = collection.
  	    find(query).
  	    cursor[JsObject]

  	val futureArticlesList: Future[List[JsObject]] = cursor.collect[List]()

  	val futureArticlesJsonArray: Future[JsArray] = futureArticlesList.map { articles => Json.arr(articles) }

 	futureArticlesJsonArray.map { articles => Ok(articles) } 
  }

  def findByName(name: String) = Action.async {
    val cursor: Cursor[JsObject] = collection.
        find(Json.obj("name" -> name)).
  		sort(Json.obj("created" -> -1)).
  		cursor[JsObject]

  		val futureArticlesList: Future[List[JsObject]] = cursor.toList()

  		val futureArticlesJsonArray: Future[JsArray] = futureArticlesList.map { articles => Json.arr(articles) }

  		 // everything's ok! Let's reply with the array
      futureArticlesJsonArray.map { articles => Ok(articles) }
  }
  
}