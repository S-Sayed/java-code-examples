Without Strategy Design Pattern
-------------------------------
- what if you want to introduce a new behavioral
	- you will change in the existing class by adding a new condition, and the new logic
	- and this may impact the existing code 
	- and the class will be doubled-in size and at some point, it will be hard to maintain/ scale
	- you will spend too much time in fixing merge conflict
	
- what if you want to use the same code in another classes in your application
	- will lead to code duplication
	

With Strategy Design Pattern (Behavioral Design Pattern)
-------------------------------------------------------- 

Definition
---------
- turns a set of behaviors into objects and makes them interchangeable inside original context object
- define family of algorithms called strategies 
and each one will be in separate class and their objects can be interchangeable at runtime by the client 
through the context object

Components 
----------
1- strategy interface 
2- concrete strategy class for each algorithm/ behavior
3- context (original class) that 
	- will expose method to the client for setting the wanted strategy
	- will have reference to the strategy interface
	- will expose method that can be called by the client and context will delegate the work to the strategy

Usage
-----
use it when you have some behavior that will be handled in different ways as shown below 
	 - Payment behavior 
	 	1. By Credit card  
	 	2. By Pay pal 
	 	
	 - Product search behavior 
	 	1. By SKU 
	 	2. By Name 
	 	
	 - Employee search behavior 
	 	1. By National ID 
	 	2. By email
	 	
	 - Map behavior
	 	1. By Car
	 	2. By Bus
	 	3. By Ship
	 	4. ...

Relations with Other Patterns
-----------------------------
similar to state design pattern but 
	- states are aware of each other 
	- strategies are independent and unaware of each other

similar to template design pattern but 
	- template can share common logic
	- strategy can't share common logic
	- Template Method works at the class level, so it’s static. 
	- Strategy works on the object level, letting you switch behaviors at runtime
	
similar to command design pattern but command design pattern is good for undo/queue operation 

Benefits
--------
- follow Open for extension, Closed for modification Principle 
	- so you can add a new strategies without affecting the existing ones and the context as well
- follow Single Responsibility Principle
- strategies can be interchangeable/ swap/ switch at run-time thought the context object 
	- which means that the strategy pattern can alter the context/ original object behavior at run-time

Drawback
--------
- clients must be aware about all the concrete strategies to be able to select a proper one.