// Reduce some of the debugging output of Spark
import org.apache.log4j.Logger
import org.apache.log4j.Level

Logger.getLogger("org").setLevel(Level.ERROR)
Logger.getLogger("akka").setLevel(Level.ERROR)

// Import the basic recommender libraries from Spark's MLlib package
import org.apache.spark.rdd._
import org.apache.spark.mllib.recommendation._
import org.apache.spark.mllib.evaluation.MulticlassMetrics

val sampleSize = 0.01 // again use 1 percent sample size for debugging!
val rawArtistAlias = sc.textFile("../Data/audioscrobbler/artist_alias.txt")
val rawArtistData = sc.textFile("../Data/audioscrobbler/artist_data.txt")
val rawUserArtistData = sc.textFile("../Data/audioscrobbler/user_artist_data.txt").sample(false, sampleSize)

rawUserArtistData.map(_.split(' ')(0).toDouble).stats()
rawUserArtistData.map(_.split(' ')(1).toDouble).stats()