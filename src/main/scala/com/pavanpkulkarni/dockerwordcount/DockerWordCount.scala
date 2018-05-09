package com.pavanpkulkarni.dockerwordcount

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SaveMode


object DockerWordCount {

  def main(args: Array[String]): Unit = {

    //Start the Spark context
    val spark = SparkSession
      .builder()
      //.master("local") //uncomment this line when running on local
      .appName("Docker_Word_Count")
      .getOrCreate()

    import spark.implicits._

    //Read some example file to a test RDD
    val inputFilename = args(0)
    val outputFilename = args(1)
    val data = spark.read.text(inputFilename).as[String]

    val words = data.flatMap(value => value.split("\\s+"))
    val groupWords = words.groupByKey(_.toLowerCase)
    val counts = groupWords.count()
    counts.show()
    
    counts.coalesce(1).write.mode(SaveMode.Overwrite).csv(outputFilename)

    //Stop the Spark context
    spark.stop

  }

}