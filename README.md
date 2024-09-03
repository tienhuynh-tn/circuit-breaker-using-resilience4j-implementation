# Circuit Breaker using Resilience4J Implementation

## What Problems Does the Circuit Breaker Pattern Solve?

In a microservices architecture, services are often interdependent, forming a chain of calls. For example, if Microservice One calls Microservice Two, which in turn calls Microservice Three, and so on, the failure of one service can impact the entire chain. If Microservice Four becomes unavailable or experiences slow performance, Microservice Three, which depends on it, will be affected. This, in turn, impacts Microservice Two, and eventually Microservice One, leading to a cascading failure throughout the system.

The circuit breaker pattern addresses this issue by detecting repeated failures in a service and "breaking" the circuit, stopping continuous requests to the failing service. This conserves system resources and prevents a single point of failure from causing a broader system outage.

Other mechanisms work alongside the circuit breaker pattern to enhance system resilience. A fallback mechanism can provide a default response when a service fails, ensuring the system remains operational. A retry mechanism allows repeated attempts to contact a temporarily unavailable service, potentially recovering from transient issues. Rate limiting restricts the number of requests to a service, preventing overload and subsequent failures. Together, these patterns help manage dependencies and mitigate cascading failures in microservices architectures.

# References
- [TBU](https://spring.io/projects/spring-cloud-circuitbreaker)
- [TBU](https://resilience4j.readme.io/)
- [TBU](https://resilience4j.readme.io/docs/circuitbreaker)
- [TBU](https://resilience4j.readme.io/docs/retry)
