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

/*val form = Form(
	mapping(
		"id" -> optional(of[String] verifying pattern(
			"""a-fA-F0-9]{24}""".r,
			"constraint.objectId")),
			"title" -> nonEmptyText,
			"content" -> text,
			"published" -> optional(of[Long]),
			"created" -> optional(of[Long]),
			"updated" -> optional(of[Long])
			) { (id, title, content, published, created, updated) => 
			Article(
				id.map(new BSONObjectID(_)),
				title,
				content,
				published.map(new DateTime(_)),
				created.map(new DateTime(_)),
				updated.map(new DateTime(_))
				)
			 } { article => 
			    Some(
			    	( article.id.map(_.stringify),
			    	  article.title,
			    	  article.content,
			    	  article.published.map(_.getMillis),
			    	  article.created.map(_.getMillis),
			    	  article.updated.map(_.getMillis))
			    	)
			}
		)
	)*/
