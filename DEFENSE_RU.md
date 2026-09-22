# Подготовка к защите — Game World Kit

## 1. Что делает Part A

Factory Method создаёт один тип продукта — `Enemy`.

Есть интерфейс `Enemy` и три реализации:
- `Goblin`
- `Skeleton`
- `Slime`

Абстрактный класс `EnemySpawner` содержит factory method:

```java
protected abstract Enemy createEnemy();
```

и общую бизнес-логику:

```java
public void startEncounter() {
    Enemy enemy = createEnemy();
    ...
    enemy.attack();
}
```

`EnemySpawner` не знает, какого конкретно врага создаст подкласс.

`GoblinSpawner`, `SkeletonSpawner`, `SlimeSpawner` наследуются от `EnemySpawner` и переопределяют `createEnemy()`.

Главная идея: **общая логика находится в родительском Creator, а решение о создании продукта передано подклассам**.

## 2. Где здесь inheritance

В Factory Method наследование видно здесь:

```java
public class GoblinSpawner extends EnemySpawner
```

Подкласс наследует `startEncounter()` и меняет только factory method `createEnemy()`.

## 3. Что делает Part B

Abstract Factory создаёт не один объект, а семейство связанных объектов:

- `Enemy`
- `Terrain`
- `Soundtrack`

Например `IceWorldFactory` создаёт только ледяное семейство:

- `IceEnemy`
- `IceTerrain`
- `IceSoundtrack`

Так клиент получает согласованные объекты одной темы.

## 4. Где здесь composition

`WorldGame` получает фабрику через конструктор:

```java
public WorldGame(WorldFactory factory)
```

То есть `WorldGame` не наследуется от фабрики, а **имеет зависимость на объект `WorldFactory` и использует его**. Это composition.

## 5. Почему WorldGame не зависит от concrete classes

Внутри `WorldGame` поля имеют типы интерфейсов:

```java
private final Enemy enemy;
private final Terrain terrain;
private final Soundtrack soundtrack;
```

Классы `ForestEnemy`, `IceEnemy`, `DesertEnemy` ему неизвестны.

## 6. Где выбирается семья

В `AbstractFactoryDemo` есть единственный `switch`, который выбирает:

- `ForestWorldFactory`
- `IceWorldFactory`
- `DesertWorldFactory`

После этого вся программа работает через `WorldFactory`.

## 7. Главное отличие Factory Method и Abstract Factory

Factory Method:
- один продукт;
- решение о создании через subclass;
- основной механизм — inheritance.

Abstract Factory:
- несколько связанных продуктов;
- клиент получает factory object;
- основной механизм для клиента — composition;
- фабрика гарантирует, что продукты одной темы создаются вместе.

## 8. OCP

Factory Method:
если нужен `Zombie`, создаём `Zombie` и `ZombieSpawner`. `EnemySpawner.startEncounter()` менять не нужно.

Abstract Factory:
если нужен новый мир `Volcano`, создаём новое семейство и `VolcanoWorldFactory`. `WorldGame` менять не нужно.

## 9. SRP

- Enemy classes отвечают за поведение врагов.
- Spawner classes отвечают за создание врагов.
- World factories отвечают за создание семьи объектов.
- `WorldGame` отвечает за использование объектов мира.
- Demo classes отвечают за запуск программы и конфигурацию.

## 10. Недостаток паттернов

Появляется много интерфейсов и классов. Если в игре всегда один враг и один мир, фабрики будут лишним усложнением.

## 11. Слабое место Abstract Factory

Добавить новую семью легко.

Но если нужно добавить новый **тип продукта**, например `Weather`, придётся изменить `WorldFactory` и все существующие concrete factories. Это слабое место Abstract Factory.
