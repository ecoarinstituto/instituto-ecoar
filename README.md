# Instituto Ecoar — Website

Site institucional do Instituto Ecoar, desenvolvido com Java + Spring Boot + Thymeleaf.

## Páginas
- `/` — Início
- `/atividades` — Atividades
- `/doacoes` — Doações
- `/contato` — Contato

## Requisitos
- Java 17+
- Maven 3.9+

## Executar localmente
```bash
mvn spring-boot:run
```
Depois abra:
http://localhost:8080

## E-mail
O formulário usa Spring Mail. Configure as variáveis de ambiente antes de iniciar:

MAIL_USERNAME=ecoarinstitutobr@gmail.com
MAIL_PASSWORD=sua_senha_de_app
MAIL_TO=ecoarinstitutobr@gmail.com

Para Gmail, recomenda-se usar uma senha de aplicativo (App Password), não a senha normal da conta.

## Doações
A página de doações usa exclusivamente o link SumUp fornecido para o Instituto Ecoar:
https://pay.sumup.com/b2c/Q3PGBIAK
O endereço pode ser sobrescrito pela variável DONATION_CHECKOUT_URL se necessário.

Não coloque chaves secretas no código.

## Publicação
O projeto inclui Dockerfile. Pode ser publicado em Render, Railway, Fly.io, AWS, Azure ou VPS com Docker.

## Observação sobre as imagens
As imagens visuais usadas no projeto foram produzidas por IA para o protótipo do site. Substitua os recortes pelas imagens finais individuais quando quiser uma biblioteca fotográfica definitiva.
