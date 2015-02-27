package controllers

import models._

import play.api._
import play.api.mvc._

import scala.concurrent._

import reactivemongo.api._

import play.modules.reactivemongo._
import play.modules.reactivemongo.json.collection.JSONCollection

import play.api.libs.json._
import play.api.libs.concurrent.Execution.Implicits._
import play.api.Play.current


object Application extends Controller with MongoController {
  
  def index = Action {
    Ok(views.html.index("The Status of Quo"))
  }

  def collection: JSONCollection = db.collection[JSONCollection]("articles")


  def create(article: Article) = Action.async {
  /*	val articleTransformer = ( __ \ 'title' ).json.pick */

        val title = article.title
        val published = article.published
  		  val json = Json.obj(
  			"title" -> title,
  			"published" -> published,
  			"created" -> new java.util.Date().getTime())

  		   collection.insert(json).map(lastError => Ok("Mongo LastError: %s".format(lastError)))
  }

  def findArticles() = Action.async {
  	val cursor: Cursor[JsObject] = collection.find(Json.obj()).cursor[JsObject]
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

    futureArticlesJsonArray.map { articles => Ok(articles) }
  }
  
}