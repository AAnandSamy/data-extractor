package com.org.data.extractor

import java.util.Date

import slick.basic.{DatabaseConfig, StaticDatabaseConfig}
import slick.jdbc.JdbcProfile

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.GetResult
import slick.jdbc.JdbcProfile
import slick.basic.{DatabaseConfig, StaticDatabaseConfig}
import slick.dbio.DBIO
import slick.jdbc.JdbcBackend.Database
import slick.driver._
import slick.driver.H2Driver.api._

object Extract extends App {
  try {
    val bf = new Date
    val db = Database.forConfig("mydb")
    val query = sql"""select clientname from x.clients""".as[String]
    val a: DBIO[Unit] =
      query.map { s =>
        s.foreach(println)
      }
    val f: Future[Unit] = db.run(a)
    Await.result(f, Duration.Inf)
    val af = new Date
    // compare execution time
    println(s"""\nBefore : $bf\nAfter  : $af""")
    println(f)

  } catch {
    case e: Exception =>
      e.printStackTrace()
  }


}
