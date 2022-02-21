# owl
Owl is a DSL that evaluates simple expressions and statements.

Owl uses ANTLR4 to generate parsers.

Here's a diagram of Owl's planned module design:
![modules](./doc/OwlArch.svg)

# groovy

功能：

- 提供一个可运行的程序，接受入参值（来自指标或者字段），返回出参。
- 从程序中解析入参字段和出参字段
- 校验程序语法
- 缓存
- **安全问题**？

### 入参结构

```
Map<String, Object>
```



### 出参结构

```
Map<String, Object>
```



# TODO
- Dividing precision/scale could be set in function definition: #avg
- list variable can be initialized at declaration time
- Caching parse tree

---
Owl has nothing to do with the [Web Ontology Language](https://en.wikipedia.org/wiki/Web_Ontology_Language).