# Owl

Owl is a DSL that evaluates simple expressions and statements.

Owl uses ANTLR4 to generate parsers.

Here's a diagram of Owl's planned module design:
![modules](./doc/OwlArch.svg)

> This project is originally designed to complement the other private project I am working on,
> so there might be some extra cost for you to use my executors directly.

# Groovy Support

There's also a groovy executor for executing predefined groovy instances. The groovy code only accepts an interface that
contain one specific single method `run`.

Parameter type:

```
Map<String, Object>
```

Return type:

```
Map<String, Object>
```

# TODO

- list variable can be initialized at declaration time
