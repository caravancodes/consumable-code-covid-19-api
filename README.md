## consumable-code-covid-19-api
[![](https://jitpack.io/v/amirisback/consumable-code-covid-19-api.svg?style=flat-square)](https://jitpack.io/#amirisback/consumable-code-covid-19-api) <br>
Eliminates the method of retrieving json data using retrofit repeatedly. so this project has a set of functions to retrieve data without the need for fetching data using the retrofit of the API

## Documentation Covid 19 Api
https://covid19api.com/

## Version Release
This Is Latest Release

    $version_release = 1.0.1

What's New??

    * Adding Get Routes *

## How To Use This Project
<h3>Step 1. Add the JitPack repository to your build file</h3>

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
<h3>Step 2. Add the dependency</h3>

	dependencies {
	        // library consumable code covid 19 api
            implementation 'com.github.amirisback:consumable-code-covid-19-api:1.0.1'
	}
	
<h3>Step 3. Declaration ConsumeCovid19Api</h3>

	val consumeCovid19Api = ConsumeCovid19Api()
    consumeCovid19Api.usingChuckInterceptor(this) // This is Code Chuck Interceptor
    consumeCovid19Api.getSummaryData(object : Covid19ResultCallback<ReponseSummary> {
        override fun getResultData(data: ReponseSummary) {
            // * PLACE YOUR CODE HERE FOR UI / ARRAYLIST *
        }

        override fun failedResult(statusCode: Int, errorMessage: String?) {
            // failed result
        }

        override fun onShowProgress() {
            // showing your progress view
        }

        override fun onHideProgress() {
            // hiding your progress view
        }
    })
            
## Function Main From This Project

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // List Routes
    // List all routes with parameters and descriptions.
    fun getRoutes(callback: Covid19ResultCallback<List<Route>>)

    // Get Summary Data
    // Return new cases and total cases per country.
    fun getSummaryData(callback: Covid19ResultCallback<ReponseSummary>)

    // Get All Data
    // This call returns ~8MB of data and currently takes around 5 seconds.
    fun getAllData(callback: Covid19ResultCallback<List<Status>>)

    // Get All Countries
    // List all countries and their provinces.
    fun getAllCountries(callback: Covid19ResultCallback<List<Country>>)

    // Get Status By Country
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getStatusByCountry(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )

    // Get Status By Country And Province
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getStatusByCountryProvince(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )

    // Get Status By Country From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getFirstRecordedByCountry(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )

    // Get Status By Country And Province From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getFirstRecordedByCountryProvince(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )


## Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

## Attention !!!
Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account
- If you like this library, please help me / you can donate to buy patreon services