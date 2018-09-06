import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{SQLContext, functions => func, _}

object firstApp{
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .master("local")
      .appName("firstApp")
      .getOrCreate()
    println("reading csv file")

    val path = "src/main/resources/titanic.csv"
    val data = sparkSession.read.option("header","true").format("csv").load(path)
    println("number of lines: ")
    println(data.count)
    data.show()
  }
}