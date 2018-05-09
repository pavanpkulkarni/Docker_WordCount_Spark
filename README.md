# Word Count in Spark - Write output to file

This repo contains a word count program that writes output to file. 

# To Run:

1. Clone this repo
2. Build the project by running - `gradle clean build`
3. Run `spark-submit` command as

	`spark-submit --master local[4] --verbose --class com.pavanpkulkarni.dockerwordcount.DockerWordCount build/libs/Docker_WordCount_Spark-1.0.jar <input_filename> <output_directory> `

	E.g:

	> spark-submit --master local[4] --verbose --class com.pavanpkulkarni.dockerwordcount.DockerWordCount build/libs/Docker_WordCount_Spark-1.0.jar "data.txt" "output"


# Output

 Output will be available under `output/part-00000-xxxxx`
 
