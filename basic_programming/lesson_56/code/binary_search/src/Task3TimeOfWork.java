public class Task3TimeOfWork {

  // Петя и Ваня красят забор.
  // Забор площади total
  // Петя красит v1 квадратных метров в день
  // Петя берёт выходной каждый третий день
  // Ваня красит v2 квадратных метров в день
  // Ваня берёт выходной каждый четвёртый день
  // За какое минимальное количество дней они покрасят забор?

  /**
   * Расчёт времени совместной работы
   * @param total количество работы
   * @param v1 ежедневная производительность первого работника (выходные раз в три дня)
   * @param v2 ежедневная производительность второго работника (выходные раз в четыре дня)
   * @return минимальное количество дней для завершения работы
   */
  public static int daysOfWork(int total, int v1, int v2) {
    int min = 0; // заведомо меньше дней, чем надо - за 0 дней не успеют
    int vMax = Math.max(v1, v2);
//    if (vMax <= 0) { // пусть v1 и v2 - положительные
//      return -1; // оба работника не работают, невозможно узнать ответ
//    }
    int daysMax = total / vMax; // количество рабочих дней для одного
    // заведомо больше дней, чем надо - работает только кто-то один
    int max = (daysMax + daysMax / 2) * 2; // умножили на 2 "для гарантии", и так должно подойти
    while (work(v1, v2, min) < total) { // пока "min" дней не хватает
      int mid = (min + max) / 2; // обычный бинарный поиск - значение в середине
      int midWork = work(v1, v2, mid);
      if (midWork < total) { // если mid тоже "не хватает", то новый min - это mid + 1
        min = midWork + 1;
      } else {
        max = midWork; // min - не ответ, но и двигать его нельзя, двигаем max
        // двигаем "с гарантией", поэтому без -1, чтобы точно "больше дней, чем нужно"
      }
    }
    return min;
  }

  /**
   * Количество совместной работы
   * @param v1 ежедневная производительность первого работника (выходные раз в три дня)
   * @param v2 ежедневная производительность второго работника (выходные раз в четыре дня)
   * @param days количество календарных дней
   * @return количество сделанной работы
   */
  public static int work(int v1, int v2, int days) {
    return v1 * (days - days / 3) + v2 * (days - days / 4);
  }
}
