--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-01-29 18:24:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "Week11-homework";
--
-- TOC entry 3338 (class 1262 OID 16398)
-- Name: Week11-homework; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Week11-homework" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE "Week11-homework" OWNER TO postgres;

\connect -reuse-previous=on "dbname='Week11-homework'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16399)
-- Name: accommodation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accommodation (
    id bigint NOT NULL,
    type character varying(32) NOT NULL,
    bed_type character varying(32) NOT NULL,
    max_guests bigint NOT NULL,
    description character varying(512) NOT NULL
);


ALTER TABLE public.accommodation OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16411)
-- Name: accommodation_room_fare_relation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accommodation_room_fare_relation (
    id bigint NOT NULL,
    accommodation_id bigint NOT NULL,
    room_fare_id bigint NOT NULL
);


ALTER TABLE public.accommodation_room_fare_relation OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16406)
-- Name: room_fare; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room_fare (
    id bigint NOT NULL,
    value_eur double precision NOT NULL,
    season character varying(32) NOT NULL
);


ALTER TABLE public.room_fare OWNER TO postgres;

--
-- TOC entry 3330 (class 0 OID 16399)
-- Dependencies: 214
-- Data for Name: accommodation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.accommodation (id, type, bed_type, max_guests, description) VALUES (4, 'double', 'double bed', 2, 'Sleeps 2 people, floor-to-ceiling windows, mini-fridge,  50-inch HDTV. Floor-to-ceiling windows. Work in comfort at the desk with ergonomic chair, stay connected with WiFi (fees apply). Make coffee and tea right in your room. Additional features include a safe, mini-fridge, iron and ironing board. These rooms have air conditioning. Refresh in the bathroom with a range of toiletries.');
INSERT INTO public.accommodation (id, type, bed_type, max_guests, description) VALUES (3, 'double', 'double bed', 2, 'Sleeps 2 people, floor-to-ceiling windows, mini-fridge,  50-inch HDTV. Floor-to-ceiling windows. Work in comfort at the desk with ergonomic chair, stay connected with WiFi (fees apply). Make coffee and tea right in your room. Additional features include a safe, mini-fridge, iron and ironing board. These rooms have air conditioning. Refresh in the bathroom with a range of toiletries.');
INSERT INTO public.accommodation (id, type, bed_type, max_guests, description) VALUES (1, 'single', 'single bed', 1, 'Floor-to-ceiling windows, WiFi, LCD TV, mini-fridge. This room has one single bed and an elegant bathroom with exclusive bath products.');
INSERT INTO public.accommodation (id, type, bed_type, max_guests, description) VALUES (2, 'single', 'single bed', 1, 'Floor-to-ceiling windows, WiFi, LCD TV, mini-fridge. This room has one single bed and an elegant bathroom with exclusive bath products.');
INSERT INTO public.accommodation (id, type, bed_type, max_guests, description) VALUES (6, 'quad', 'two double beds', 4, 'Perfect for children. Sleeps 4 people. Floor-to-ceiling windows, WiFi, LCD TV, mini-fridge. This room has two double beds and an elegant bathroom with exclusive bath products. ');
INSERT INTO public.accommodation (id, type, bed_type, max_guests, description) VALUES (7, 'king', 'king bed', 2, 'Our stylish guest room features floor-to-ceiling windows. Work in comfort at the desk with chair, stay connected with WiFi (fees apply) or unwind and watch your favorite channel or TV show on our 50-inch LCD TV. Make coffee and tea right in your room. This room has a king size bed.
This room has air conditioning and an elegant bathroom with exclusive bath products. Sleeps 2.');
INSERT INTO public.accommodation (id, type, bed_type, max_guests, description) VALUES (5, 'twin', 'twin beds', 2, 'Bathrobe, slippers, complimentary water, floor-to-ceiling windows, WiFi.
Unwind in this contemporary and spacious, deluxe room with floor-to-ceiling windows. 
Catch up on work at the desk, stay connected with WiFi (fees apply), or watch your favorite channel or TV show on our 50-inch LCD TV. Additional features include mini-fridge, and MP3 alarm clock.
This room has two twin beds and an elegant bathroom with exclusive bath products. Sleeps 2 adults or children');


--
-- TOC entry 3332 (class 0 OID 16411)
-- Dependencies: 216
-- Data for Name: accommodation_room_fare_relation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (14, 7, 8);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (13, 7, 7);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (12, 6, 6);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (11, 6, 5);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (10, 5, 4);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (9, 5, 3);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (8, 4, 4);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (7, 4, 3);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (6, 3, 4);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (5, 3, 3);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (4, 2, 2);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (3, 2, 1);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (2, 1, 2);
INSERT INTO public.accommodation_room_fare_relation (id, accommodation_id, room_fare_id) VALUES (1, 1, 1);


--
-- TOC entry 3331 (class 0 OID 16406)
-- Dependencies: 215
-- Data for Name: room_fare; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.room_fare (id, value_eur, season) VALUES (8, 300, 'summer');
INSERT INTO public.room_fare (id, value_eur, season) VALUES (7, 150, 'winter');
INSERT INTO public.room_fare (id, value_eur, season) VALUES (6, 250, 'summer');
INSERT INTO public.room_fare (id, value_eur, season) VALUES (5, 125, 'winter');
INSERT INTO public.room_fare (id, value_eur, season) VALUES (4, 200, 'summer');
INSERT INTO public.room_fare (id, value_eur, season) VALUES (3, 100, 'winter');
INSERT INTO public.room_fare (id, value_eur, season) VALUES (2, 150, 'summer');
INSERT INTO public.room_fare (id, value_eur, season) VALUES (1, 75, 'winter');


--
-- TOC entry 3181 (class 2606 OID 16405)
-- Name: accommodation accommodation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accommodation
    ADD CONSTRAINT accommodation_pkey PRIMARY KEY (id);


--
-- TOC entry 3185 (class 2606 OID 16415)
-- Name: accommodation_room_fare_relation accommodation_room_fare_relation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accommodation_room_fare_relation
    ADD CONSTRAINT accommodation_room_fare_relation_pkey PRIMARY KEY (id);


--
-- TOC entry 3183 (class 2606 OID 16410)
-- Name: room_fare room_fare_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room_fare
    ADD CONSTRAINT room_fare_pkey PRIMARY KEY (id);


--
-- TOC entry 3186 (class 2606 OID 16416)
-- Name: accommodation_room_fare_relation accommodation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accommodation_room_fare_relation
    ADD CONSTRAINT accommodation_fk FOREIGN KEY (accommodation_id) REFERENCES public.accommodation(id) NOT VALID;


--
-- TOC entry 3187 (class 2606 OID 16421)
-- Name: accommodation_room_fare_relation room_fare_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accommodation_room_fare_relation
    ADD CONSTRAINT room_fare_fk FOREIGN KEY (room_fare_id) REFERENCES public.room_fare(id) NOT VALID;


-- Completed on 2023-01-29 18:24:21

--
-- PostgreSQL database dump complete
--

