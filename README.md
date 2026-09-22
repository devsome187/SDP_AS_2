# Game World Kit

This is my Assignment 2 project about two creational design patterns: **Factory Method** and **Abstract Factory**.

The theme I chose is **Game World Kit**.

## Part A — Factory Method

In this part, the program creates one enemy.

There are three enemy types:

- Goblin
- Skeleton
- Slime

They all implement the `Enemy` interface.

`EnemySpawner` is the abstract creator. It has the factory method:

```java
protected abstract Enemy createEnemy();
```

The concrete spawners are:

- `GoblinSpawner`
- `SkeletonSpawner`
- `SlimeSpawner`

Each spawner decides which enemy to create.

For example:

```java
@Override
protected Enemy createEnemy() {
    return new Goblin();
}
```

The main idea is that `EnemySpawner` works with the `Enemy` interface and does not need to know the exact enemy class.

## Part B — Abstract Factory

In this part, the program creates a whole game world.

Each world has:

- Enemy
- Terrain
- Soundtrack

There are three world themes:

### Forest
- `ForestEnemy`
- `ForestTerrain`
- `ForestSoundtrack`

### Ice
- `IceEnemy`
- `IceTerrain`
- `IceSoundtrack`

### Desert
- `DesertEnemy`
- `DesertTerrain`
- `DesertSoundtrack`

The `WorldFactory` interface looks like this:

```java
public interface WorldFactory {
    Enemy createEnemy();
    Terrain createTerrain();
    Soundtrack createSoundtrack();
}
```

Each concrete factory creates objects from the same theme.

For example, `IceWorldFactory` creates:

```text
IceEnemy
IceTerrain
IceSoundtrack
```

`WorldGame` receives a `WorldFactory` in its constructor and uses it to create the world.

```java
public WorldGame(WorldFactory factory) {
    this.enemy = factory.createEnemy();
    this.terrain = factory.createTerrain();
    this.soundtrack = factory.createSoundtrack();
}
```

Because of this, `WorldGame` does not need to know whether it is working with Forest, Ice, or Desert classes.

## Difference between the patterns

**Factory Method** creates one type of product.

In my project:

```text
Enemy
```

It mainly uses inheritance because concrete spawners extend `EnemySpawner`.

**Abstract Factory** creates a group of related products.

In my project:

```text
Enemy + Terrain + Soundtrack
```

It uses composition because `WorldGame` receives a `WorldFactory` object.

## SOLID

This project also shows the Open/Closed Principle.

For example, if I want to add a new enemy, I can create a new `Enemy` class and a new spawner without changing the main logic in `EnemySpawner`.

If I want to add a new world, for example Volcano, I can create:

```text
VolcanoEnemy
VolcanoTerrain
VolcanoSoundtrack
VolcanoWorldFactory
```

and `WorldGame` can still work the same way.

The classes also have separate responsibilities. Enemies contain enemy behaviour, factories create objects, and `WorldGame` uses the created objects.

## Project structure

```text
src/
├── factorymethod/
│   ├── Enemy.java
│   ├── Goblin.java
│   ├── Skeleton.java
│   ├── Slime.java
│   ├── EnemySpawner.java
│   ├── GoblinSpawner.java
│   ├── SkeletonSpawner.java
│   ├── SlimeSpawner.java
│   └── FactoryMethodDemo.java
│
└── abstractfactory/
    ├── Enemy.java
    ├── Terrain.java
    ├── Soundtrack.java
    ├── ForestEnemy.java
    ├── ForestTerrain.java
    ├── ForestSoundtrack.java
    ├── IceEnemy.java
    ├── IceTerrain.java
    ├── IceSoundtrack.java
    ├── DesertEnemy.java
    ├── DesertTerrain.java
    ├── DesertSoundtrack.java
    ├── WorldFactory.java
    ├── ForestWorldFactory.java
    ├── IceWorldFactory.java
    ├── DesertWorldFactory.java
    ├── WorldGame.java
    └── AbstractFactoryDemo.java
```

## Small disadvantage

These patterns create more classes.

For a very small program with only one enemy or one world, using factories would probably be unnecessary. But they are useful when the program has several variants and may grow later.
