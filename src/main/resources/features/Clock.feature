#language: pt
#enconding: UTF-8

Funcionalidade: Clock mobile

Eu como um usuario gostaria de adicionar um novo alarme para que eu acorde mais cedo no dia seguinte

Cenario: Adicionar novo alarme

Dado que o usuario acione o menu Alarme
Quando o usuario acionar o botao Adicionar Alarme
E configurar a hora para "4:25", "AM"
Entao o app adiciona um novo alarme com as informacoes:
	|Repeat										|
	|Default (Cesium)					|
	|Label										|
	|Delete										|
	




