import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<Person> queue = new LinkedList<>();
    private Queue<Person> market = new LinkedList<>();

    @Override
    public void addPersonToQueue(Person person) {
        queue.add(person);
        System.out.println(person.getName() + " добавлен в очередь.");
    }

    @Override
    public void removePersonFromQueue() {
        Person person = queue.poll();
        if (person != null) {
            System.out.println(person.getName() + " удалён из очереди.");
        } else {
            System.out.println("Очередь пуста.");
        }
    }

    @Override
    public void acceptPerson(Person person) {
        market.add(person);
        System.out.println(person.getName() + " добавлен в магазин.");
    }

    @Override
    public void releasePerson() {
        Person person = market.poll();
        if (person != null) {
            System.out.println(person.getName() + " вышел из магазина.");
        } else {
            System.out.println("Магазин пуст.");
        }
    }

    public void update() {
        // Примеры принятия и отдачи заказов
        if (!queue.isEmpty()) {
            Person person = queue.poll();
            acceptPerson(person);
        }

        if (!market.isEmpty()) {
            releasePerson();
        }
    }

    public static void main(String[] args) {
        Market market = new Market();

        // Создание людей
        Person person1 = new Person("Алексей");
        Person person2 = new Person("Мария");
        Person person3 = new Person("Иван");

        // Добавление людей в очередь
        market.addPersonToQueue(person1);
        market.addPersonToQueue(person2);
        market.addPersonToQueue(person3);

        // Обновление состояния магазина
        market.update();
        market.update();
        market.update();

        // Удаление людей из очереди
        market.removePersonFromQueue();
        market.removePersonFromQueue();

        // Обновление состояния магазина
        market.update();
    }
}
