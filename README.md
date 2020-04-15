# parking-slot-problem
parking lot problem
I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot isgiven a number starting at 1 increasing with increasing distance from the entry pointin steps of one. I want to create an automated ticketing system that allows mycustomers to use my parking lot without human intervention.When a car enters my parking lot, I want to have a ticket issued to the driver. Theticket issuing process includes us documenting the registration number (numberplate) and the colour of the car and allocating an available parking slot to the carbefore actually handing over a ticket to the driver (we assume that our customers arenice enough to always park in the slots allocated to them). The customer should beallocated a parking slot which is nearest to the entry. At the exit the customer returnsthe ticket with the time the car was parked in the lot, which then marks the slot theywere using as being available. Total parking charge should be calculated as per theparking time. Charge applicable is $10 for first 2 hours and $10 for every additionalhour.

We interact with the system via a simple set of commands which produce a specificoutput. Please take a look at the example below, which includes all the commandsyou need to support -they're self-explanatory. The system should accept a filenameas a parameter at the command prompt and read the commands from that file.Example: FileTo install all dependencies, compile and run tests:$ bin/setupTo run the code so it accepts input from a file:
$ bin/parking_lot file_inputs.txtCommands• 
Create parking lot of size n : create_parking_lot{capacity}• 
Park a car : park {car_number}• 
Remove(Unpark) car from : leave {car_number} {hours}•
Print status of parking slot : status
Input (contents of file):create_parking_lot 6 
park KA-01-HH-1234
park KA-01-HH-9999
park KA-01-BB-0001
park KA-01-HH-7777
park KA-01-HH-2701
park KA-01-HH-3141
leave KA-01-HH-3141 4
status
