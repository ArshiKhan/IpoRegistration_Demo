# IpoRegistration_Demo
Project to perform basic crud operations for IPO registration


#### Swagger Link [http://localhost:8001/swagger-ui.html#!]

### Add new IPO
curl --location --request POST 'http://localhost:8001/ipo' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"STOVEKRAFT",
    "lowerBandPrice": 516,
    "upperBandPrice": 518,
    "expiryDate": "2020-01-22T01:00:00.000Z"
}'



Success Response :

New ipo created!


Failure Response :

{
    "errorCode": "BAD_REQUEST",
    "message": "IPO : STOVEKRAFT already present. Try again!"
}




### Get IPO details


curl --location --request GET 'http://localhost:8001/ipo' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA=='


Success Response :

[
    {
        "name": "HOMEFIRST",
        "lowerBandPrice": 516,
        "upperBandPrice": 518,
        "expiryDate": 1609545600000
    },
    {
        "name": "STOVEKRAFT",
        "lowerBandPrice": 516,
        "upperBandPrice": 518,
        "expiryDate": 1612141200000
    }
]


### Create User

curl --location --request POST 'http://localhost:8001/user' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"arshikhan",
    "contactNumber":"7019629892",
    "email":"abcd123@gmail.com"
}'


Success Response :

New user created!


Failure Response :


{
    "errorCode": "BAD_REQUEST",
    "message": "User with contact number : 99017862727 already present. Try again!"
}


### Register for an IPO


curl --location --request POST 'http://localhost:8001/user/ipo/registration' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--data-raw '{
    "ipoName":"STOVEKRAFT",
    "cutOffPrice": 516,
    "lotsApplied": 10,
    "contactNumber":"9745231313"
}'


Success Response :


Registered for IPO



Failure Response :

{
    "errorCode": "BAD_REQUEST",
    "message": "Already subscribed for ipo : STOVEKRAFT"
}


{
    "errorCode": "BAD_REQUEST",
    "message": "No ipo details found for name : STOVEKRAFT1"
}


{
    "errorCode": "BAD_REQUEST",
    "message": "Ipo window expired. Cannot register for HOMEFIRST"
}


{
    "errorCode": "BAD_REQUEST",
    "message": "Cut Off price not valid for ipo : IRFC"
}


### Get user IPO details


curl --location --request GET 'http://localhost:8001/user/ipo/registration/9745231313' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA=='



Success Response :


[
    {
        "contactNumber": "9745231313",
        "ipoName": "STOVEKRAFT",
        "cutOffPrice": 516,
        "lotsApplied": 10
    }
]