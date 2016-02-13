# PersistenceAPI
Otro ORM m�s. Creado por pura diversi�n y aprendizaje.

Alguna de las caracter�sticas que soporta son:

* Carga/grabaci�n de jerarqu�a de objetos, evidente, �no?.
* Robusto, eficiente y muy ligero. Testado en producci�n en varios proyectos.
* Querys by example<br>
	MyUser user = new MyUser();<br>
	user.setName("David");<br>
	user.setAge(32);<br>
	DAOUtilityExample.find(user);<br>
	//ejemplo	[DAOUtilityExample](src/test/java/com/ogm/persistance/test/dao/impl/DAOUtilityExample.java)
* Paginaci�n sencilla
* Lazy loading con Proxy de JDK.
* POJOS Anotados o ficheros por XML.
* Query Object (DSL) inplementado con [ANTLR](http://www.antlr.org/)<br>
	select * from MyUser where name =:=name and age=:=age<br>
	se transforma autom�ticamente en una sentencia v�lida para el motor RDBMS<br>
	SELECT * FROM T_USER WHERE TX_NAME = ? AND NU_AGE = ?<br>
* Soporte para diferentes dialectos de base de datos, se incluye Oracle, Derby, HSQL y MySql
* Transacci�n program�tica o gestionada por el contendor, ya sea un Aplication Server o una aplicaci�n Spring.
* Pool de conexiones [gestionado](https://commons.apache.org/proper/commons-dbcp/) o acceso al contexto JNDI.
* Se puede limitar por configuraci�n el n�mero de registros devueltos en cualquier sentencia de forma autom�tica, para evitar sentencias que devuelvan millones de registros por error.
* Fluent API para programar sentencias din�micas<br>
`		Long idExpediente = new Long(1172L); `<br>
`		SQLSelect select = new SQLSelect(); `<br>
`		//a�adimos todos los campos de la salida `<br>
`		select.addSelectField(EstadoExpediente.class, "fechaDetalle") `<br>
`				.addSelectField(EstadoExpediente.class, "estadoDetalle") `<br>
`				.addSelectField(EstadoExpediente.class, "numeroBloque") `<br>
`				.addSelectField(TipoBloque.class, "textoGui", "descripcion"); `<br>
<br>
		//a�adimos las tablas<br>
`		select.addFrom(EstadoExpediente.class).addFrom(TipoBloque.class); `<br>
		<br>
		//a�adimos las restricciones<br>
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


Pues parece que est� muy bien, �no?. <br>
Funciona y funciona muy bien, me lo he pasado teta desarroll�ndolo, pero no lo recomedar�a para su uso en producci�n, b�sicamente porque no hay ning�n tipo de soporte, aunque el c�digo es muy legible y facilmente extensible, puede ser dif�cil al principio entender c�mo funciona.

Quiz�s te interesen mis pensamientos en voz alta
[M�s que Ceros y Unos](https://masquecerosyunos.wordpress.com/)
