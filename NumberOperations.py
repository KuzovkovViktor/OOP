numbers = [10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9]

print("Список чисел:", end=" ")
for number in numbers:
    print(number, end=" ")
print()

print("Числа в форматі цілих чисел:", end=" ")
for number in numbers:
    print(int(number), end=" ")
print()

print("Числа в дробному форматі:", end=" ")
for number in numbers:
    print(f"{number:.2f}", end=" ")
print()

integer_numbers = [number for number in numbers if isinstance(number, int)]
double_numbers = [number for number in numbers if isinstance(number, float)]

print("Цілі числа:", end=" ")
for number in integer_numbers:
    print(number, end=" ")
print()

print("Дробні числа:", end=" ")
for number in double_numbers:
    print(number, end=" ")
print()

max_number = numbers[0]
for number in numbers:
    if number > max_number:
        max_number = number
print("Найбільше число:", max_number)
