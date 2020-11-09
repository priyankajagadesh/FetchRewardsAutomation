# FetchRewardsAutomation

## Description
With the given Facebook native application, an automation framework is designed to test logging in to Facebook, searching for Fetch Rewards page and clicking the "Like" button.

### Pre-requisites 
* GitHub
* Maven

### Configuration Steps
* `git clone https://github.com/priyankajagadesh/FetchRewardsAutomation.git`  
* Locate `\src\test\resources\testng.xml` file and enter your facebook credentials in test parameters.
``` 
<test name="login">
        <parameter name="user" value="xxxx" />
        <parameter name="pass" value="xxxx" />
        <classes>
            <class name="com.fetchrewards.test.TestScript" />
        </classes>
 </test>
```
* Navigate to Project folder in terminal and run command `mvn clean package -DskipTests=true`
* Fetch the zipped jar file in target folder

### Execution steps
I have made use of AWS Device Farm to run the automation script. Follow the below steps:
1. Log into AWS Management Console via https://791778026030.signin.aws.amazon.com/console.
2. I have added IAM user using Pre-defined credentials and restricted access(AWS Device Farm only)
3. Enter the credentials which have been shared in the Email.
4. Go to AWS Management console and search for Device Farm

    <img width="508" alt="Capture" src="https://user-images.githubusercontent.com/74079576/98499872-7ef8fc80-2210-11eb-97bb-7eb1000d7f21.PNG">

5. Create a new project.

    <img width="509" alt="pix2" src="https://user-images.githubusercontent.com/74079576/98500010-e151fd00-2210-11eb-8bc8-bb3024f76a3b.PNG">

6. Give a suitable name to your project and Create Project

    <img width="421" alt="pix3" src="https://user-images.githubusercontent.com/74079576/98500061-05154300-2211-11eb-90ff-cd552f59b10e.PNG">

7. Create new Run

    <img width="512" alt="pix4" src="https://user-images.githubusercontent.com/74079576/98500132-37bf3b80-2211-11eb-94b8-de3172dff4d2.PNG">
    <img width="511" alt="pix5" src="https://user-images.githubusercontent.com/74079576/98500162-56bdcd80-2211-11eb-9ac8-2299ce7fe0a2.PNG">

8. Upload .apk file. You can see your app details once it is successfully uploaded.

    <img width="510" alt="pix6" src="https://user-images.githubusercontent.com/74079576/98500213-8371e500-2211-11eb-948c-fe5dfcba868b.PNG">

9. Select Appium Java TestNg in configure your test section and upload Final-zip-file.zip, taken from the target directory as explained in the configuration steps.

    <img width="488" alt="pix7" src="https://user-images.githubusercontent.com/74079576/98500272-abf9df00-2211-11eb-96a2-fbafefcd6635.PNG">

10. Select devices from the set of available devices. Incase you want to use some other device which is not mentioned in the list, opt for create new device pool.

    <img width="508" alt="pix8" src="https://user-images.githubusercontent.com/74079576/98500323-d2b81580-2211-11eb-9601-5435cf39c8a5.PNG">

11. Please reduce maximum execution time per device to 5 mins to limit my time consumption in case anything goes wrong. (I have a free consumption limit of 1000 minutes only)

    <img width="492" alt="pix9" src="https://user-images.githubusercontent.com/74079576/98500551-6be72c00-2212-11eb-8364-0bea8447ed6b.PNG">

Now the project is ready. You can also see logs of the devices by selecting test application. This may take some time to start. On completion of test suite, the results would be displayed along with video, logs, screenshots(if the code snippet was added to tests) and performance analysis.

