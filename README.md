# Spring Service (Layered Structure)

## Lernziele

- [ ] Verstehen, wie die Schichtenstruktur in Spring (Controller, Service, Repository) aufgebaut ist.
- [ ] Kennenlernen der Rolle von DTOs (Data Transfer Objects) in der Kommunikation zwischen Schichten.
- [ ] Fähigkeit entwickeln, einfache REST-Backends mit der controller-service-repo Struktur zu erstellen.

## Einführung

In der Softwareentwicklung ist eine klare und strukturierte Aufteilung der Verantwortlichkeiten von großer Bedeutung.
Das Spring Framework bietet eine bewährte Schichtenarchitektur, die uns dabei hilft, Code sauber zu organisieren und zu
warten. In diesem Modul werden wir uns mit der Spring-Service-Struktur beschäftigen, die aus den Schichten Controller,
Service und Repository besteht. Wir werden auch Data Transfer Objects (DTOs) kennenlernen, die eine effiziente
Kommunikation zwischen den Schichten und externen Modulen ermöglichen.

## Annotationen
- @Component ist die allgemeine Annotation für alle Spring-Beans. Die folgenden Annotationen sind spezifischere
  Versionen von @Component tun aber das Gleiche.
    - @Service
    - @Repository
    - ...


## DTOs (Data Transfer Objects)
```java
public class NewOrder {
    private List<Product> products;

    // Getter und Setter
}

public class Order {
    private String id;
    private List<Product> products;
    private OrderStatus status;
    private Instant createdOn;
}
```

> 💡 Beachten Sie, dass DTOs oft auch zur Validierung von Daten verwendet werden können, bevor sie in die Datenbank
> gespeichert werden.

## Controller

Der Controller ist die Schnittstelle zwischen der Benutzeroberfläche (oder externen Anfragen) und dem dahinterliegenden
System. Er empfängt Anfragen, verarbeitet sie und gibt die entsprechenden Antworten zurück. Ein einfaches Beispiel
könnte ein Controller sein, der Anfragen für Benutzerregistrierungen entgegennimmt.

```java

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    private final OrderService orderService;

    ...

    @PostMapping
    public Order createOrder(@RequestBody NewOrder newOrder) {
        return orderService.createOrder(newOrder);
    }
}
```

## Service

Der Service ist die Geschäftslogikschicht. Hier werden die eigentlichen Aktionen und Operationen durchgeführt. Der
Controller ruft Methoden im Service auf, um die Anfragen zu verarbeiten. Ein Beispiel für einen Service könnte die
Validierung und Speicherung eines neuen Benutzers sein.

```java

@Service
public class OrderService {

    private private OrderRepository orderRepository;

    ...

    public User createOrder(NewOrder newOrder) {
        // Validierung und Speicherung der Bestellung
        Order order = new Order("123", newOrder.products, OrderStatus.PROCESSING, Instant.now());
        return orderRepository.save(order);
    }
}
```

## Repository

Das Repository ist für den Zugriff auf die Datenbank oder eine andere Datenspeicherquelle verantwortlich. Hier werden
die Datenbankabfragen und -operationen durchgeführt. In unserem Beispiel könnte das Repository die Aufgabe haben,
Benutzerdaten in der Datenbank zu speichern und abzurufen.

```java

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // Datenbankabfragen und -operationen
}
```

## Data Transfer Objects (DTOs)

DTOs sind einfache Java-Klassen, die dazu dienen, Daten zwischen den Schichten zu übertragen, ohne unnötige Details
preiszugeben. Sie helfen dabei, die Kommunikation effizient und klar zu gestalten. Ein typisches Beispiel wäre ein DTO,
das Benutzerinformationen zwischen dem Controller und dem Service überträgt.

## Weiterführende Ressourcen

- Spring Framework Dokumentation zu
  Schichtenarchitektur: [Link](https://docs.spring.io/spring-framework/docs/current/reference/html/architecture.html)
- Baeldung Tutorial zu Spring Service Schichtenstruktur: [Link](https://www.baeldung.com/spring-service-layer)
- Spring Boot und RESTful Web Services: [Link](https://spring.io/guides/gs/rest-service/)