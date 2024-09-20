# Island v1.0

The application is a simulation program that I developed in 2004, that models the ecosystem of an imaginary island. The goal is to create a food chain involving individuals of three species (grass, grasshoppers, and lizards) so that they can survive as long as possible and avoid extinction. The application was built using the Swing framework.

## Requirements and Setup
Java Runtime Environment (JRE) 1.8

Note: The program is optimized for JRE 1.8 and may not run correctly on newer versions.

To start the application, run the `Island.java` file located in the `org.example` package.

## Life on the Island

In the middle of the ocean, there is an uninhabited island where only three species live: a type of grass, a herbivorous animal, specifically a grasshopper, and a predator, which in this case is a lizard. These three species form a food chain. The grass feeds on nutrients from the soil, the grasshopper eats the grass, and the lizard hunts grasshoppers. The grass has inexhaustible resources, as we assume that the island has constant and abundant rainfall. The survival of the animals, however, largely depends on whether they can find food. If the food in their environment runs out, they set out in search of new sources. However, they can only endure starvation for a limited time, after which they perish. After reaching a certain age, all living beings die, their bodies decompose, and their biomass returns to the soil. The creatures can also reproduce at certain intervals.

The island is divided into territories of equal size. Each territory has a limit on how many individuals of a given species it can support. For example, a grasshopper can only move to another territory if the number of grasshoppers there has not yet reached the maximum. The animals can move from their own territory in four different directions (up, down, right, left). Diagonal movement is not possible. Animals on the edge of the island can only migrate to adjacent territories, so falling into the water is not a possibility.

Reproduction occurs differently for grass and animals. The wind, blowing in different directions, carries the grass seeds to neighboring territories. A seed will only take root if the territory can still support it. If there is no room for more grass, the seed will perish. Animals give birth to their offspring in their own territory, and the survival of the offspring also depends on the territory’s capacity to sustain them.

## Simulation

We receive information about the number of living creatures after each time period. This time period represents a unit of time, which can be considered as a day, a week, or even a month. The frequency of the periods is adjustable. More frequent cycles allow for a more dynamic simulation, while less frequent cycles make it easier to track the movement of individuals.

The simulation can be started using the start button in the settings window or the appropriate icon in the main window. Before starting, you can specify whether time should start automatically or by pressing a button. When starting, the program randomly places the creatures on the island based on the specified population percentage. If you want to manually determine the location of each individual, select zero percent for population, and before starting the time, you will have the opportunity to place the creatures manually on the empty island. Time can also be paused and resumed at any point during the simulation. The age of the introduced creatures is randomly determined, so not all individuals are zero years old when placed on the island. Therefore, it can happen that a newly introduced creature reaches the maximum age in the next time period and dies immediately. It is also possible to specify whether the animals search for food consciously or randomly. In conscious searching, they move to the territory where they believe there is the most food, while in random searching, they just wander from one territory to another.

The territories on the island are represented by small squares. The presence of creatures in each territory is indicated by a colored square. If there is grass in a territory, it is represented by a green square. If grasshoppers are present, they are indicated by a smaller red square. The presence of lizards is shown by a small blue square. The darkness of the color represents the number of individuals of each species – the more individuals of a species in a given territory, the darker the green, red, or blue square. If a territory is gray, it means no species are present.

The number of creatures on the island can be tracked using a diagram, where three colored bars represent the different species. The population trends can also be followed on a graph, which always displays data from the last 250 time periods on the island. The most essential information can be accessed via a data sheet.

## Anomalies

The characteristics of each species can be freely adjusted before starting. This results in the fact that it is rarely possible to create a viable ecosystem, but at the same time, we can simulate numerous impossible life situations. The following strange settings may answer any questions that arise.

- For example, it may happen that a species cannot go extinct, even if all of its food sources have disappeared from the island. This can occur if the hunger level required for starvation is higher than the threshold for reproductive maturity, meaning a newborn animal becomes capable of reproducing before it starves to death.

- Another faulty setting could be when a territory can only support a single animal. In this case, even though the animal reproduces, the territory only has space for one individual, so the newborn animal dies immediately. Without offspring, the species will soon go extinct.

## Screenshots

<img src=docs/06.png alt="" width="800">
<br>
<img src=docs/04.png alt="" width="600">
<br>
<img src=docs/05.png alt="" width="600">
<br>
<img src=docs/02.png alt="" width="600">
<br>
<img src=docs/01.png alt="" width="400">
<br>
<img src=docs/03.png alt="" width="300">