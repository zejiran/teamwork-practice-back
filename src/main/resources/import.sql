INSERT INTO ITINERARY_ENTITY(ID, LODGING, TRANSPORTATION) VALUES (100, 'Equipaje, estadia con desayuno', 'Viaje por autobus');

INSERT INTO OUTING_ENTITY(ID,DATE, NAME,PARTICIPATION_COST,PLACE,ITINERARY_ID) VALUES (100,'2011-09-10', 'Conoce la magia del Parque Tayrona', 500000, 'Parque Natural Tayrona', 100);

INSERT INTO QUOTATION_ENTITY (ID, PARTICIPANTS,STATUS,TOTAL_COST) VALUES (100, 1, 1, 500000);

INSERT INTO INSURANCE_ENTITY (ID,CONDITIONS,FEATURES,NAME,PRICE) VALUES (100, 'Solo para personas naturales', 'Seguro para COVID-19 y viajes mayores a una semana', 'COVID seguro', 40000);

INSERT INTO MULTIMEDIA_ENTITY(ID, FILE_NAME, MEDIA_TYPE, EXTENSION) VALUES (100, 'grabacion_salida', 0, 'mp4');

INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (100, 'pepe', 'CC', '10022', 'Calle 13');

INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (100, 100);

INSERT INTO TRANSACTION_ENTITY(ID, CREATION_DATE, PAYMENT, VALUE, CLIENT_ID) VALUES (7, '2011-09-10',1, 250, 100);

INSERT INTO ENTERPRISE_ENTITY(ID, REPRESENTATIVE_ID, USER, PASSWORD, MAIL) VALUES (100, 100, 'usuario.uwu', 'contrase', 'pp.prz@gmail.com');

INSERT INTO COMMENT_ENTITY(ID, TEXT, LIKES, DISLIKES) VALUES (12, 'melo', 3, 1);

INSERT INTO POST_ENTITY(ID, RATINGS, TITLE, COMMENT_ID) VALUES (5,  9, 'Muy buen lugar para visitar', 12);

INSERT INTO REVIEW_ENTITY(ID,SCORE,COMMENT_ID) VALUES (45, 5, 12);

INSERT INTO ROUTE_ENTITY(ID, DIFFICULTY, ESTIMATED_DURATION, OUTING_ID) VALUES (1,1,100,100);

INSERT INTO COMPLEMENTARY_INFORMATION_ENTITY(ID,DESCRIPTION,RECOMMENDATION) VALUES (1,'Venezuela','Llevar comida');


COMMIT;
