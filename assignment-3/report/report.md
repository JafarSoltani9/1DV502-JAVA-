# Reflection on my Intended Design

1.Are there any classes missing in your design, why/why not?
I missed only one class in my object diagram, which is the Console UI. Apart from that, my diagram is the same as the one provided in Assignment3. The Console UI class is relevant depending on the type of game being designed, as it would handle the user interface.

2.Did you have any extra classes in your design, why/why not?
I have a class that is not on the class diagram from assignment 3 and that is ComputerPlayer. This could be more because I simply had no experience of that game in real life, so that would help me extend my idea and add extra classes on the design. Although I learned lately that I could add classes like “jail” which exist in the real game.

3.Are there differences in naming the classes? How should classes be named?
The classes are almost named the same and with the same concept but with small changes. It is very important when naming a class, the name of the class can describe the class and easier understand concept of the class.

4.Are there differences in the relations between the classes?´
i have almost the same relation between classes and there are some wrong relation. I have inheritance relation between HumanPlayer and player class  The relation could be realization between humanPlayer and Player. But I have designed a directional association, it is much better to have a realization association between classes. Realization gives more flexibility and the interface allows to have more classes like computerPlayer or smartPlayer etc.. without changing too much in the code, the player interface abstracts the common behaviour of all players and decouples the code to make easier to understand and less dependent on specific implementation.


5.Did you connect the objects using dependency/association or did you use id-connections?
I've used some weak-dependencies and associations in my design Based on the objects relations.

6.Did you manage to divide the complexity/behaviour into different classes or do you have one central class having most of the code?
I've manged or atleast tried to divide the complexity in some ways where some classes have similar attributes and operations.


7.What differences are there for the object diagram?
There isn't much difference between my object diagram and the one given in Assignment 3, except that I missed including the console UI class in my diagram. I also missed some values and attributes, but I fixed them the second time around. I believe having a good object diagram is crucial because it provides a general overview of the program and makes it easier to understand how the program works.

8.What differences are there for the sequence diagram?
My sequence diagram appears too simplistic and lacks the necessary step-by-step information. I missed including the ConsoleUI or UserInterface in my design, which was a significant error. Additionally, starting the steps from the Board class was incorrect, as the game begins with the player. If the player decides not to move forward or make a purchase, the game will not progress as expected.

9.Do you think you made a good job in your initial design, why/why not?
I do think that i did a good jobe and created a design as simple as i cloud but i do also know that there can be more and better improvment to my design where it do leak som important details in some places which can makes it hard for someone who doesn't know Programmering language.

10.What is the most important thing you learned by designing first?
I have learned that designing requires creativity and flexibility much more than I thought before and it is a time-consuming work where providing details, dependency, associtaions and also other important parts from the class design to the object design and also the most important part sequence diagram.