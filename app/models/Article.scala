package models

import org.joda.time.DateTime
import reactivemongo.bson._

case class Article(
	id: Option[BSONObjectID],
	title: String,
	content: String,
	published: Option[DateTime],
	created: Option[DateTime],
	updated: Option[DateTime]
)

/*
object Article {
	implicit object ArticleBSONReader extends BSONDocumentReader[Article] {
		def fromBSON(document: BSONDocument): Article = {
			val doc = document.toTraversable
			Article(
				doc.getAs[BSONObjectID]("_id"),
				doc.getAs[BSONString]("title"),
				doc.getAs[BSONString]("content"),
				doc.getAs[BSONDateTime]("published").map(dt => new DateTime(dt.value)),
				doc.getAs[BSONDateTime]("created").map(dt => new DateTime(dt.value)),
				doc.getAs[BSONDateTime]("updated").map(dt => new DateTime(dt.value))
			)
		}
	}

	implicit object ArticleBSONWriter extends BSONDocumentWriter[Article] {
		def toBSON(arcile: Article) =  {
			val bson = BSONDocument(
				"_id" -> article.id.getOrElse(BSONObjectID.generate),
				"title" -> BSONString(article.title),
				"content" -> BSONString(article.content),
				if(article.published.isDefined)
				    bson += "published" -> BSONDateTime(article.published.get.getMillis),
				if(article.created.isDefined)
				    bson += "created" -> BSONDateTime(article.created.get.getMillis),
				if(article.updated.isDefined)
				    bson += "updated" -> BSONDateTime(article.updated.get.getMillis)
				bson
		    )
		}
	}
} */
