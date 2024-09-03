# Circuit Breaker using Resilience4J Implementation

## What Problems Does the Circuit Breaker Pattern Solve?

In a microservices architecture, services are often interdependent, forming a chain of calls. For example, if Microservice One calls Microservice Two, which in turn calls Microservice Three, and so on, the failure of one service can impact the entire chain. If Microservice Four becomes unavailable or experiences slow performance, Microservice Three, which depends on it, will be affected. This, in turn, impacts Microservice Two, and eventually Microservice One, leading to a cascading failure throughout the system.

The circuit breaker pattern addresses this issue by detecting repeated failures in a service and "breaking" the circuit, stopping continuous requests to the failing service. This conserves system resources and prevents a single point of failure from causing a broader system outage.

Other mechanisms work alongside the circuit breaker pattern to enhance system resilience. A fallback mechanism can provide a default response when a service fails, ensuring the system remains operational. A retry mechanism allows repeated attempts to contact a temporarily unavailable service, potentially recovering from transient issues. Rate limiting restricts the number of requests to a service, preventing overload and subsequent failures. Together, these patterns help manage dependencies and mitigate cascading failures in microservices architectures.

## How the Circuit Breaker Pattern Works

The circuit breaker pattern is designed to prevent cascading failures in microservices by managing the flow of requests between services based on their availability. It operates with three states: **Closed**, **Open**, and **Half-Open**.

1. **Closed State**:  
   In the closed state, the circuit breaker allows all requests to flow between microservices. For example, if an employee service calls a department service, and both services are up and running, the circuit breaker remains closed. This state indicates that the system is functioning normally, and all requests from the employee service to the department service are permitted.

2. **Open State**:  
   The circuit breaker transitions to an open state when the failure rate of requests exceeds a predefined threshold. For instance, if the threshold is set at 50%, and out of five requests from the employee service to the department service, three fail, the circuit breaker moves to the open state. In this state, all further requests are blocked to prevent overwhelming the failing service. This helps conserve system resources by avoiding unnecessary attempts to call a service that is likely still down.

3. **Half-Open State**:  
   After a specified time limit (e.g., 5 seconds) in the open state, the circuit breaker moves to the half-open state. In this state, the circuit breaker allows a limited number of test requests (e.g., three) to check if the failing service has recovered. If the test requests are successful (e.g., the department service responds correctly), the circuit breaker transitions back to the closed state, allowing normal operation to resume. If the requests fail, the circuit breaker returns to the open state to prevent further failed attempts.

The flow between these states helps reduce the number of calls to a failing service and prevents wasting resources. If the service recovers, the circuit breaker returns to normal operation; if not, it continues to block requests until the service becomes available again. This mechanism ensures a more resilient microservices architecture by handling service failures gracefully and avoiding cascading failures.

# References
- Course: [Building Microservices with Spring Boot & Spring Cloud](https://www.udemy.com/course/building-microservices-with-spring-boot-and-spring-cloud/) by [Ramesh Fadatare (Java Guides)](https://www.udemy.com/user/ramesh-fadatare/)
- [TBU](https://spring.io/projects/spring-cloud-circuitbreaker)
- [TBU](https://resilience4j.readme.io/)
- [TBU](https://resilience4j.readme.io/docs/circuitbreaker)
- [TBU](https://resilience4j.readme.io/docs/retry)
