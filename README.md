Context
=======

We are building a method that will allow the providers connected to our platform to handle their interventions in their calendar.
We already have classes for the intervention and we need to build a method that will allow us to calculate all the available windows.

Classes
=======
The classes are provided but it is just an indication. You can freely implement your own classes if the wanted behavior is the same.

## Event
* An event is either an opening a or busy window. A busy window means that the company already has an intervention scheduled or cannot take an intervention this specific window.
* An opening event can be recurring, that means that it repeats itself every week.

Exercise
========
The goal of the exercise is to calculate every available slots from a specific date to another.
We want to build a method whose signature is like written in the class (availabilities method).
The return value of the method should be something like given in the return_example.json file.
The format does not have to be JSON, it can be any kind of object you prefer, as soon as the organization is good.

Example
========
Here is what happens in the src.Content.java file :

Let's take a company called "Plomberie FAURE", it put in the platform that it is usually available every week on Friday from 10:30 to 14:00. A resident has scheduled an intervention on Friday July 8th from 11:30 to 12:30 with it. Another resident wishes to know when the company is available from the 4th to the 10th of July. The answer should be that the company is available Friday, July 8th from 10:30 to 11:30 and from 12:30 to 14:00. For the test, we will assume that the algorithm returns an array with available windows/slots in the calendar, like described in the src.Content.java file.

Tests
========
Using library "junit 1.5"

Details
=======
If there is no opening or busy event for a certain window, that means the company is not available.