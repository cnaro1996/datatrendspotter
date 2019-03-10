Contains an application that lets users pick categories of a data-set to compare and plot, and identifies any positive trends within the categories selected.

Built using Java, Java Spring Boot framework, ReactJS, Apache POI, and Git.

Currently using the Food Environment Atlas dataset for demoing purposes.

Only supports .xls extensions!

--

Demo with http://localhost:8080/api/datasets

--
You can create, read, update, and delete datasets with the following HTTPie commands.

http POST :8080/api/dataset name='example dataset' --ignore-stdin
http :8080/api/dataset/6 --ignore-stdin
http PUT :8080/api/dataset/6 name='example dataset' --ignore-stdin
http DELETE :8080/api/dataset/6 --ignore-stdin