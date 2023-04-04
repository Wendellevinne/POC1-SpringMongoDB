# POC1-SpringMongoDB

A simple CRUD application using Kotlin + Spring + MongoDB.
Thanks to Kotlin and Spring, the implementation was not difficult, despite some problems that I faced when trying to do the save and update operations with the default ID generator of MongoDB. I needed to create an extra field named "userID" to be able to do some operations like sorts, updates and deletes in the project.

I've heard about a dependency called "Kmongo", which seems to solve that problems. I'll be searching about it in the next weeks.
Feel free to comment or suggest any fix to my code. I'm new with Kotlin, so probably there are some aspects of the language that I don't know about or that I'm using wrongly.
