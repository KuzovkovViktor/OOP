# Создаем список чисел
numbers = [10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9]

# Выводим числа в ряд
print("Список чисел:", end=" ")
for number in numbers:
    print(number, end=" ")
print()

# Выводим числа в формате целых чисел
print("Числа в форматі цілих чисел:", end=" ")
for number in numbers:
    print(int(number), end=" ")
print()

# Выводим числа в дробном формате с двумя знаками после запятой
print("Числа в дробному форматі:", end=" ")
for number in numbers:
    print(f"{number:.2f}", end=" ")
print()

# Разделяем числа на целые и дробные
integer_numbers = [number for number in numbers if isinstance(number, int)]
double_numbers = [number for number in numbers if isinstance(number, float)]

# Выводим целые числа
print("Цілі числа:", end=" ")
for number in integer_numbers:
    print(number, end=" ")
print()

# Выводим дробные числа
print("Дробні числа:", end=" ")
for number in double_numbers:
    print(number, end=" ")
print()

# Находим и выводим самое большое число
max_number = numbers[0]
for number in numbers:
    if number > max_number:
        max_number = number
print("Найбільше число:", max_number)
