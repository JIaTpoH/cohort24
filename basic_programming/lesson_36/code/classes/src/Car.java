// класс Car - автомобиль
// классы vs. объекты
// Класс и объект - как общая разновидность и конкретный экземпляр
// Класс и объект - как тип и переменная
// Класс String как строки в целом, и объект/экземпляр класса String как отдельная конкретная строка

// Класс как чертёж программы - и программа, которую мы запускаем, как конкретный объект

// - Автомобиль vs. конкретныйАвтомобиль
// - Класс - как архитектурный план, чертёж для объекта
//   - Класс - шаблон с определёнными методами и атрибутами

// - Класс - единица кода, большая, чем метод

public class Car {

  // атрибуты - свойства конкретного экземпляра или класса в целом
  private double enginePower; // мощность двигателя
  private String model; // модель
  private String plate; // номерной знак

  // обычно атрибуты напрямую (из других классов) менять нельзя
  // они должны быть недоступны
  // поэтому все атрибуты пишем так:
  // private Тип имяАтрибута

  // методы - команды, связанные с этим классом
  // все команды пишутся только внутри одного из методов

  // Первый метод класса - конструктор (constructor) - от слова "конструировать" - создавать.
  // Его название совпадает с названием класса
  // Конструктор без аргументов -- это то, что вызывается при создании объекта оператором new.
  // Конструктор без аргументов создаётся автоматически для любого класса самой Java.
  // Писать его не нужно - но можно, если вы хотите что-то добавить.

  // Конструктор с аргументами позволяет задать атрибуты сразу при создании
  // Как только мы создали конструктор с аргументами, системный конструктор без аргуметов пропадает
  // Если нужно использовать конструктор без аргументов, придётся его написать самостоятельно
  public Car() {
    this.model = "UNKNOWN MODEL"; // this в любом методе - обращение к ТЕКУЩЕМУ объекту
    this.plate = "NO NUMBER";
  }

  // Конструкторов может быть несколько -- а может быть только один. Решать вам.
  public Car(String model) {
    this.model = model; // this в любом методе - обращение к ТЕКУЩЕМУ объекту этого класса
    this.plate = "NO NUMBER";
    // если поле - например, enginePower - не инициализируется в конструкторе, то оно так и остаётся
    // пустым - c null для классов и 0 для примитивных типов
  }

  public Car(String model, String plate) {
    this.model = model;
    this.plate = plate;
  }

  public Car(String model, double power, String plate) {
    this.model = model;
    enginePower = power; // можно не писать this, если не с чем перепутать
    this.plate = plate;
  }

  // метод, который напечатает информацию о конкретном объекте в консоль
  // нарушение инкапсуляции - класс Car не должен думать ни про консоль, ни про файлы
  public void printInfo() {
    System.out.printf("%s: %s (%f)%n", model, plate, enginePower);
  }

  // метод, который отдаст информацию о конкретном объекте в виде строки
  public String getInfo() {
    return String.format("%s: %s (%f)", model, plate, enginePower);
  }

  // методы для изменения атрибутов принято называть сеттерами (setters)
  // set - задать (установить)
  // название метода традиционно выглядит как public void setАтрибут(ТипАтрибута новоеЗначение)
  // метод для изменения (задания, если его не было) номера
  public void setPlate(String plate) {
    this.plate = plate;
  }

  public void setEnginePower(double enginePower) {
    this.enginePower = enginePower;
  }

  public void setModel(String model) {
    // здесь, как и в любом сеттере, может быть проверка корректности
    this.model = model;
  }

  // Сеттеры создаются сразу для всех атрибутов, которые пользователь (другой код) должен
  // иметь возможность менять.

  // методы для получения значений атрибутов принято называть геттерами (getters)
  // get - получить
  // название метода традиционно выглядит как public ТипАтрибута getАтрибут()
  public String getPlate() {
    return plate;
  }

  public String getModel() {
    return model;
  }

  public double getEnginePower() {
    return enginePower;
  }

  // Геттеры создаются сразу для всех атрибутов, которые пользователь (другой код) должен
  // иметь возможность смотреть.
}
