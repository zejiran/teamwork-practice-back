INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (100, 'peperez@gmail.com', 'asdfTER12', 'peperez.hola');

INSERT INTO CLIENT_ENTITY (ID) VALUES (100);

INSERT INTO ITINERARY_ENTITY(ID, LODGING, TRANSPORTATION) VALUES (100, 'Equipaje, estadia con desayuno', 'Viaje por autobus');

INSERT INTO OUTING_ENTITY(ID,DATE, NAME,PARTICIPATION_COST,PLACE,ITINERARY_ID) VALUES (100,'2011-09-10', 'Conoce la magia del Parque Tayrona', 500000, 'Parque Natural Tayrona', 100);


INSERT INTO QUOTATION_ENTITY (ID, PARTICIPANTS,STATUS,TOTAL_COST) VALUES (100, 1, 1, 500000);

INSERT INTO INSURANCE_ENTITY (ID,CONDITIONS,FEATURES,NAME,PRICE) VALUES (100, 'Solo para personas naturales', 'Seguro para COVID-19 y viajes mayores a una semana', 'COVID seguro', 40000);

INSERT INTO MULTIMEDIA_ENTITY(ID, FILE_NAME, MEDIA_TYPE, EXTENSION) VALUES (100, 'grabacion_salida', 0, 'mp4');

INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (100, 'pepe', 'CC', '10022', 'Calle 13');

INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (100, 100);

INSERT INTO ENTERPRISE_ENTITY(ID) VALUES (100);

INSERT INTO TRANSACTION_ENTITY(ID, CREATION_DATE, PAYMENT, VALUE, CLIENT_ID) VALUES (7, '2011-09-10',1, 250, 100);

INSERT INTO BLOG_ENTITY(ID) VALUES (2)

INSERT INTO POST_ENTITY(ID, RATINGS, BLOG_ID) VALUES (5,  9, 2);

INSERT INTO ENTERPRISE_ENTITY(ID, MAIL, PASSSWORD, USER, BLOG_ID, CALENDAR_ID, REPRESENTATIVE_ID) VALUES (10, pepe, pepe123, pepe.perez, 2, 100);

INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER, BLOG_ID) VALUES (32, 'prt@gmail.com', 'ddd', 'prt.777', 2);

INSERT INTO ADMIN_ENTITY(ID,USER,PASSWORD,MAIL) VALUES (32, 'pepe','33', 'prt@gmail.com')

INSERT INTO COMMENT_ENTITY(ID, TEXT, LIKES, DISLIKES, USERID, USER_TYPE, USERNAME, DATE) VALUES (12, 'melo', 3, 1, 32, 'ADMIN', 'pepe', '2012-04-11');

INSERT INTO COMMENT_ENTITY(ID, TEXT, LIKES, DISLIKES, COMMENT_ID, USERNAME) VALUES (13, 'deacuerdo', 3, 1, 12, 'pedrito');

INSERT INTO REVIEW_ENTITY(ID,SCORE,COMMENT_ID) VALUES (45, 5, 12);

INSERT INTO ROUTE_ENTITY(ID, DIFFICULTY, ESTIMATED_DURATION) VALUES (1,1,100);

INSERT INTO LOCATION_ENTITY(ID,  LATITUDE, LONGITUDE, MAP_ID) VALUES (1, 500, 500.0, 1);

INSERT INTO LOCATION_ENTITY(ID, LATITUDE, LONGITUDE, MAP_ID) VALUES (2, 550.0, 520.0, 1);

INSERT INTO COMPLEMENTARY_INFORMATION_ENTITY(ID,DESCRIPTION,RECOMMENDATION) VALUES (105,'Venezuela','Llevar comida');

INSERT INTO ACTIVITY_ENTITY(ID) VALUES (100);

INSERT INTO GUIDE_ENTITY(ID) VALUES (100);


COMMIT;
