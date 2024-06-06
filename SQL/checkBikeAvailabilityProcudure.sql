CREATE OR REPLACE FUNCTION public.checkbikeavailability()
RETURNS TABLE(id integer, modelo character varying, peso double precision, marca character varying, estado character varying, sis_mudancas character varying, atr_disc character, vel_max double precision, autonomia double precision, gps integer)
LANGUAGE plpgsql
AS $function$
BEGIN
    RETURN QUERY
    SELECT b.id, b.modelo, b.peso, b.marca, b.estado, b.sis_mudancas, b.atr_disc, b.vel_max, b.autonomia, b.gps
    FROM bicicleta b
    WHERE b.estado = 'livre';
END;
$function$;
