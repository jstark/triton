triton
======

An arithmetic expression parser written in Scala and based on parser combinators

status
======
Triton creates an AST of the expression. The following grammar is parsed:

```
expr := term ("+" term | "-" term)*

term := prim ("*" prim | "/" prim)*

prim := "-" prim 
      | prim ("**" prim)* 
      | ID func? 
      | FLOAT 
      | "(" expr ")"

func := "(" (farg (", " farg)*)? ")"

farg := expr
```

example
======
After running test.scala, type an expression to get its AST:

e.g after typing and pressing ENTER
```
1 + sin(2, x)
```
the following AST is returned:
```
[1.11] parsed: OpAdd(Number(1.0),OpFun(sin,List(Number(2.0), Variable(x))))
```
