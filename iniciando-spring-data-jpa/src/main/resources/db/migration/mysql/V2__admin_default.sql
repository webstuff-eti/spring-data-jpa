
-- INSERT DATA DOCUMENT IN  DATABASE MYSQL OF NAME "contato"
INSERT INTO  DOCUMENTS  (  id, RG, CPF	) VALUES (	NULL, "99924135013", "243599203" );
INSERT INTO  DOCUMENTS  (  id, RG, CPF	) VALUES (	NULL, "97724135013", "243577203" );
INSERT INTO  DOCUMENTS  (  id, RG, CPF	) VALUES (	NULL, "96624135013", "243566203" );

addressHome.setCity("Pouso Alegre");
		addressHome.setStreet("Rua xyz, 01");
		addressHome.setType(TypeAddress.RESIDENCIAL);

-- INSERT DATA ADDRESS IN  DATABASE MYSQL OF NAME "contato"
INSERT INTO  ADDRESSES  (  ID_ADDRESS, CITY, STREET, TYPE_ADDRESS ) VALUES ( NULL, "São Paulo", "Rua xxx", "RESIDENCIAL" );
INSERT INTO  ADDRESSES  (  ID_ADDRESS, CITY, STREET, TYPE_ADDRESS ) VALUES ( NULL, "São Paulo", "Rua yyy", "COMERCIAL");

INSERT INTO  ADDRESSES  (  ID_ADDRESS, CITY, STREET, TYPE_ADDRESS) VALUES (	NULL, "Pouso Alegre", "Rua aaa", "RESIDENCIAL");
INSERT INTO  ADDRESSES  (  ID_ADDRESS, CITY, STREET, TYPE_ADDRESS) VALUES (	NULL, "Pouso Alegre", "Rua bbb", "COMERCIAL");

INSERT INTO  ADDRESSES  (  ID_ADDRESS, CITY, STREET, TYPE_ADDRESS) VALUES (	NULL, "Registro", "Rua ccc", "RESIDENCIAL");
INSERT INTO  ADDRESSES  (  ID_ADDRESS, CITY, STREET, TYPE_ADDRESS) VALUES (	NULL, "Registro", "Rua ddd", "COMERCIAL");


-- INSERT DATA PHONE IN  DATABASE MYSQL OF NAME "contato"
-- TODO: Consultar ID na tabela PERSONS
INSERT INTO  PHONES  (  ID_PHONE, TYPE_PHONE, PHONE_NUMBER, PERSON_ID  ) VALUES (	NULL, " ", " ", 1 );
INSERT INTO  PHONES  (  ID_PHONE, TYPE_PHONE, PHONE_NUMBER, PERSON_ID  ) VALUES (	NULL, " ", " ", 1 );

INSERT INTO  PHONES  (  ID_PHONE, TYPE_PHONE, PHONE_NUMBER, PERSON_ID  ) VALUES (	NULL, " ", " ", 1 );
INSERT INTO  PHONES  (  ID_PHONE, TYPE_PHONE, PHONE_NUMBER, PERSON_ID  ) VALUES (	NULL, " ", " ", 1 );

INSERT INTO  PHONES  (  ID_PHONE, TYPE_PHONE, PHONE_NUMBER, PERSON_ID  ) VALUES (	NULL, " ", " ", 1 );
INSERT INTO  PHONES  (  ID_PHONE, TYPE_PHONE, PHONE_NUMBER, PERSON_ID  ) VALUES (	NULL, " ", " ", 1 );

			
-- INSERT DATA PERSON IN  DATABASE MYSQL OF NAME "contato"
-- TODO: Importante: mudar o tipo da coluna de VARCHAR para Bigint para AGE
-- TODO: Consultar ID na tabela DOCUMENTS
INSERT INTO  testejpa.PERSONS  (  ID_PERSON, FIRST_NAME, LAST_NAME, AGE, DOCUMENT_ID) VALUES  ( NULL, " ", " ", 37, 1);
INSERT INTO  testejpa.PERSONS  (  ID_PERSON, FIRST_NAME, LAST_NAME, AGE, DOCUMENT_ID) VALUES  ( NULL, " ", " ", 37, 1);
INSERT INTO  testejpa.PERSONS  (  ID_PERSON, FIRST_NAME, LAST_NAME, AGE, DOCUMENT_ID) VALUES  ( NULL, " ", " ", 37, 1);






