PGDMP                 	        y         	   summaryDB    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24576 	   summaryDB    DATABASE     h   CREATE DATABASE "summaryDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "summaryDB";
                postgres    false            �            1259    24580    peoples    TABLE     -  CREATE TABLE public.peoples (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    surname character varying(200) NOT NULL,
    sex character varying(10),
    age integer,
    created_at timestamp without time zone,
    update_at timestamp without time zone,
    company_id bigint
);
    DROP TABLE public.peoples;
       public         heap    admin    false            �            1259    24578    peoples_id_seq    SEQUENCE     w   CREATE SEQUENCE public.peoples_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.peoples_id_seq;
       public          admin    false    201            �           0    0    peoples_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.peoples_id_seq OWNED BY public.peoples.id;
          public          admin    false    200            �            1259    24592 	   companies    TABLE     �   CREATE TABLE public.companies (
    id bigint DEFAULT nextval('public.peoples_id_seq'::regclass) NOT NULL,
    name character varying(100) NOT NULL,
    created_at timestamp without time zone NOT NULL
);
    DROP TABLE public.companies;
       public         heap    admin    false    200            �            1259    24586    logs    TABLE     �   CREATE TABLE public.logs (
    application character(20),
    log_date date NOT NULL,
    logger character(250) NOT NULL,
    log_level character(10) NOT NULL,
    message character(4000) NOT NULL
);
    DROP TABLE public.logs;
       public         heap    postgres    false            +           2604    24583 
   peoples id    DEFAULT     h   ALTER TABLE ONLY public.peoples ALTER COLUMN id SET DEFAULT nextval('public.peoples_id_seq'::regclass);
 9   ALTER TABLE public.peoples ALTER COLUMN id DROP DEFAULT;
       public          admin    false    201    200    201            �          0    24592 	   companies 
   TABLE DATA           9   COPY public.companies (id, name, created_at) FROM stdin;
    public          admin    false    203   1       �          0    24586    logs 
   TABLE DATA           Q   COPY public.logs (application, log_date, logger, log_level, message) FROM stdin;
    public          postgres    false    202   �       �          0    24580    peoples 
   TABLE DATA           a   COPY public.peoples (id, name, surname, sex, age, created_at, update_at, company_id) FROM stdin;
    public          admin    false    201   �       �           0    0    peoples_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.peoples_id_seq', 10, true);
          public          admin    false    200            0           2606    24596    companies companies_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.companies
    ADD CONSTRAINT companies_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.companies DROP CONSTRAINT companies_pkey;
       public            admin    false    203            .           2606    24585    peoples peoples_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.peoples
    ADD CONSTRAINT peoples_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.peoples DROP CONSTRAINT peoples_pkey;
       public            admin    false    201            1           2606    24607    peoples fk_company_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.peoples
    ADD CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES public.companies(id) ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.peoples DROP CONSTRAINT fk_company_id;
       public          admin    false    2864    201    203            �   U   x�]�!�  @ݾb��Z��Sdf� ���yN��=��GN!r�v%��\
Y�"���k��s%��`�q��T4֤�"��L�      �      x������ � �      �   �   x�34�0��֋M�9/L���b#��~aׅ�r�:��r�r���+X�V1s.#΀���"ΰ������<�!1y��&D�b�esˎ�/�@]xa�ÌHp�	�9@�� =:�¦.콰D��
6�Ę7��M����=�^�:� �!.535%�`K.C��u�d�Ǎ��K�=... �T�7     