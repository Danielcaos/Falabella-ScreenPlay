--
-- PostgreSQL database dump
--

-- Dumped from database version 15.0
-- Dumped by pg_dump version 15.0

-- Started on 2023-08-12 19:45:15

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
-- TOC entry 215 (class 1259 OID 49167)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id integer NOT NULL,
    name character varying(145) NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 49166)
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 49173)
-- Name: search; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.search (
    id integer NOT NULL,
    product character varying(145) NOT NULL
);


ALTER TABLE public.search OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 49172)
-- Name: search_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.search ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.search_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3325 (class 0 OID 49167)
-- Dependencies: 215
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, name, quantity) FROM stdin;
1	Televisor LG 50 pulgadas LED 4K Ultra HD Smart TV	2
2	Televisor LG nanocell 65NANO75 4k smart tv con thinq ai inteligencia artificial	2
3	Televisor LG 70 pulgadas NANO CELL 4K Ultra HD Smart TV	2
4	Televisor Caixun 40 pulgadas LED Full HD Smart TV	2
5	Televisor Samsung 50 pulgadas QLED 4K Ultra HD Smart TV F-QN50LS03	2
6	Televisor Samsung 50 pulgadas Crystal UHD 4K HDR Smart TV UN50CU8000	2
7	Televisor Samsung 65 pulgadas LED 4K Ultra HD Smart TV UN65BU8000	2
8	Televisor Samsung 50 Pulgadas Crystal UHD 4K Ultra HD Smart TV UN50BU8000	2
9	Televisor TCL 55 pulgadas LED 4K Ultra HD Smart TV 55P635	4
10	Televisor Samsung 65 pulgadas LED 4K Ultra HD Smart TV UN65BU8000	3
11	Televisor TCL 50 Pulgadas LED 4K Ultra HD Smart TV	2
12	Televisor LG 50 pulgadas LED 4K Ultra HD Smart TV	4
13	Televisor Samsung 50 Pulgadas Crystal UHD 4K Ultra HD Smart TV UN50BU8000	4
\.


--
-- TOC entry 3327 (class 0 OID 49173)
-- Dependencies: 217
-- Data for Name: search; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.search (id, product) FROM stdin;
1	televisor
\.


--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 214
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_id_seq', 13, true);


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 216
-- Name: search_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.search_id_seq', 1, true);


--
-- TOC entry 3179 (class 2606 OID 49171)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 3181 (class 2606 OID 49177)
-- Name: search search_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.search
    ADD CONSTRAINT search_pkey PRIMARY KEY (id);


-- Completed on 2023-08-12 19:45:18

--
-- PostgreSQL database dump complete
--

