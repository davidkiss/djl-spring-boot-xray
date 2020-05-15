# Overview
Sample Spring Boot app using https://github.com/awslabs/djl that can detect COVID-19 using X-ray images.
Please note it only runs on mac or linux as it uses Tensorflow.

# Build
Run `mvn compile`.

# Run
This app is based on https://github.com/aws-samples/djl-demo/tree/master/covid19-detection sample project and it needs the Tensorflow module to be downloaded first before it can be run. 

Run the following command:
```
mkdir models
cd models
curl https://djl-tensorflow-javacpp.s3.amazonaws.com/tensorflow-models/covid-19/saved_model.zip | jar xv
cd ..

./mvnw spring-boot:run -Dai.djl.repository.zoo.location=models/saved_model
```

Then visit http://localhost:8080/index.html to get diagnose on X-ray image URLs.
Sample images to use:
- [COVID-19 infected lungs](https://github.com/ieee8023/covid-chestxray-dataset/tree/master/images)
- [Normal lungs](https://www.kaggle.com/paultimothymooney/chest-xray-pneumonia)
