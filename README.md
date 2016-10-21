# advanced-process-development-labs-etc issue 48

## Instructions
1. mvn clean and install components.
2. replace the flight-service war in the deployments folder for advanced-lab-3.
3. follow all other instructions for advanced-lab-3 to deploy and start the process definition.

## Questions:

1. receiving unmarshalling error:

  ```Unmarshalling Error: org.acme.specialtripsagency.flightservice.AcmeFlightServiceFault is not known to this context ```
  * How to get rid of it?
  * Have tried to import the WSDL, should we also add the components to the models jar and replace the model jar component?
2. How to resolve with reQueue?
