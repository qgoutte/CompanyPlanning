# Transfer Treatment 💸

## Context
We are building a method that will allow the providers connected to our platform to handle their interventions in their calendar.
We already have classes for the intervention and we need to build a method that will allow us to calculate all the available windows.

## Classes
The classes are provided but it is just an indication. You can freely implement your own classes if the wanted behavior is the same.

### Event
* An event is either an opening a or busy window. A busy window means that the company already has an intervention scheduled or cannot take an intervention this specific window.
* An opening event can be recurring, that means that it repeats itself every week.

## Exercise
The goal of the exercise is to calculate every available slots from a specific date to another.
We want to build a method whose signature is like written in the class (availabilities method).
The return value of the method is a list of date.

## Tests
Using library "junit 1.5"
