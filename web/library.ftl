[#ftl/]
[#macro html]
<html>
  [#nested]
</html>
[/#macro]

[#macro body]
<body>
  <h1>Hello World</h1>
  <p>
    [#nested]
  </p>
</body>
[/#macro]

[#function sum one two three]
  [#return one + two + three]
[/#function]