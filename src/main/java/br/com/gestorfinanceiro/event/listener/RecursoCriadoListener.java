package br.com.gestorfinanceiro.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gestorfinanceiro.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {
		
		HttpServletResponse response = event.getResponse();
		adicionarHeaderLocation(event, response);

	}

	public void adicionarHeaderLocation(RecursoCriadoEvent event, HttpServletResponse response) {
		
		Long codigo = event.getCodigo();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/usuario").buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
	}

}
