package com.p7.client.proxies;

import com.p7.client.entity.Emprunt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(contextId = "msEmpruntProxy", name = "zuul-server")
public interface MsEmpruntProxy {

    @GetMapping(value = {"/ms_emprunt/mesEmprunt/{userId}"})
    List<Emprunt> getEmpruntById(@PathVariable Long userId);

    @GetMapping(value = {"/ms_emprunt/allEmprunts"})
    @ResponseBody
    List<Emprunt> getAllEmprunts();

    @PostMapping(value = {"/ms_emprunt/emprunt"})
    Emprunt setEmprunt(@RequestParam Long livreId);

    @PostMapping(value = {"/ms_emprunt/extendEmprunt/{empruntId}"})
    Emprunt extendEmprunt(@PathVariable Long empruntId);

}