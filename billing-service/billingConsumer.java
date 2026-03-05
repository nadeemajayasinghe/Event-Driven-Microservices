@Service
public class BillingConsumer {

    @KafkaListener(topics = "order-topic", groupId = "billing-group")
    public void consume(String message) {
        System.out.println("Billing Service Received: " + message);
    }
}