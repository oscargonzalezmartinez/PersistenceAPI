# PersistenceAPI
Otro ORM más. Creado por pura diversión y aprendizaje.

Alguna de las características que soporta son:

* Carga/grabación de jerarquía de objetos, evidente, ¿no?.
* Robusto, eficiente y muy ligero. Testado en producción en varios proyectos.
* Querys by example<br>
	MyUser user = new MyUser();<br>
	user.setName("David");<br>
	user.setAge(32);<br>
	DAOUtilityExample.find(user);<br>
	//ejemplo	[DAOUtilityExample](src/test/java/com/ogm/persistance/test/dao/impl/DAOUtilityExample.java)
* Paginación sencilla
* Lazy loading con Proxy de JDK.
* POJOS Anotados o ficheros por XML.
* Query Object (DSL) inplementado con [ANTLR](http://www.antlr.org/)<br>
	select * from MyUser where name =:=name and age=:=age<br>
	se transforma automáticamente en una sentencia válida para el motor RDBMS<br>
	SELECT * FROM T_USER WHERE TX_NAME = ? AND NU_AGE = ?<br>
* Soporte para diferentes dialectos de base de datos, se incluye Oracle, Derby, HSQL y MySql
* Transacción programática o gestionada por el contendor, ya sea un Aplication Server o una aplicación Spring.
* Pool de conexiones [gestionado](https://commons.apache.org/proper/commons-dbcp/) o acceso al contexto JNDI.
* Se puede limitar por configuración el número de registros devueltos en cualquier sentencia de forma automática, para evitar sentencias que devuelvan millones de registros por error.
* Fluent API para programar sentencias dinámicas<br>
`		Long idExpediente = new Long(1172L); `<br>
`		SQLSelect select = new SQLSelect(); `<br>
`		//añadimos todos los campos de la salida `<br>
`		select.addSelectField(EstadoExpediente.class, "fechaDetalle") `<br>
`				.addSelectField(EstadoExpediente.class, "estadoDetalle") `<br>
`				.addSelectField(EstadoExpediente.class, "numeroBloque") `<br>
`				.addSelectField(TipoBloque.class, "textoGui", "descripcion"); `<br>
<br>
		//añadimos las tablas<br>
`		select.addFrom(EstadoExpediente.class).addFrom(TipoBloque.class); `<br>
		<br>
		//añadimos las restricciones<br>
`		select.addCondition(SQLCondition.getAND(EstadoExpediente.class, "expediente", <br>idExpediente)) `<br>
`			.addCondition(new <br>SQLJoinCondition(EstadoExpediente.class,"numeroBloque",TipoBloque.class,"numeroBloque")); `
<br>
`		SQLOrderBy orderBy =  new SQLOrderBy(); `
<br>
`		orderBy.addField(EstadoExpediente.class, "fechaDetalle"); `
<br>
`		orderBy.addField(EstadoExpediente.class, "numeroBloque"); `
<br>
<br>
`		select.setOrderBy(orderBy); `

<br>
`		select.setOutputModel(EstadoExpediente.class); `
<br>


Pues parece que está muy bien, ¿no?. <br>
Funciona y funciona muy bien, me lo he pasado teta desarrollándolo, pero no lo recomedaría para su uso en producción, básicamente porque no hay ningún tipo de soporte, aunque el código es muy legible y facilmente extensible, puede ser difícil al principio entender cómo funciona.

Quizás te interesen mis pensamientos en voz alta
[Más que Ceros y Unos](https://masquecerosyunos.wordpress.com/)
