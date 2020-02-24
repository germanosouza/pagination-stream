# pagination-stream

When it comes the time to consume huge data from an external service, it's not feasible to retrieve everything in one shot due to a series of reasons. Processing data in batches and designing an interface between an external service client and our environment is a good choice. 
Because the stream doesn’t store the date it can be used to safely process the required amount of data.

PaginationService is the main class, where there is an attribute of ExternalService. In order to make the test straightforward, the external service is emulated in the class ExternalServiceTestConfiguration.

This is the full project for the example explained by **Tomasz Kiełbowicz** at https://blog.softwaremill.com/why-when-and-how-to-return-stream-from-your-java-api-instead-of-a-collection-c30e7ebc5407. 
