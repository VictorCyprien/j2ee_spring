package fr.limayrac.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aspectDeLogging {

	public aspectDeLogging() {
		// TODO Auto-generated constructor stub
	}
	
	@Before("execution(* fr.limayrac.controller.*.*(..))")
	public void logArguments (JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String nomClasse = joinPoint.getSignature().getDeclaringTypeName();
		String nomMethode = joinPoint.getSignature().getName();
		System.out.println("1 (@Before) " + nomClasse + "." + nomMethode + "-------------");
		System.out.println("######## Arguments de la méthode");
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println("#########");
	}
	
	
	@Around("execution(* fr.limayrac.controller.*.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		long t1 = System.currentTimeMillis();
		Object valeurDeRetour = joinPoint.proceed();
		long t2 = System.currentTimeMillis();
		long duree = t2 - t1;
		String nomClasse = joinPoint.getSignature().getDeclaringTypeName();
		String nomMethode = joinPoint.getSignature().getName();
		System.out.println("2 (@Around) " + nomClasse + "." + nomMethode + " : durée d'éxecution = " + duree + "ms");
		return valeurDeRetour;
	}
	
	
	@AfterReturning(value = "execution(* fr.limayrac.controller.*.*(..))", returning = "valeurDeRetour")
	public void logValeurDeRetour(JoinPoint joinPoint, Object valeurDeRetour) {
		String nomClasse = joinPoint.getSignature().getDeclaringTypeName();
		String nomMethode = joinPoint.getSignature().getName();
		System.out.println("3 (@AfterReturning) " + nomClasse + "." + nomMethode + "-------------");
		System.out.println("Valeur de retour = " + valeurDeRetour);
	}
	
	
	@AfterThrowing(pointcut = "execution(* fr.limayrac.controller.*.*(..))", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		String nomClasse = joinPoint.getSignature().getDeclaringTypeName();
		String nomMethode = joinPoint.getSignature().getName();
		System.out.println("4 (@AfterThrowing) " + nomClasse + "." + nomMethode + "-------------");
		System.out.println("Message de l'exception = " + exception.getMessage());
	}
	
	
	@After("execution(* fr.limayrac.controller.*.*(..))")
	public void nettoyage(JoinPoint joinPoint) {
		String nomClasse = joinPoint.getSignature().getDeclaringTypeName();
		String nomMethode = joinPoint.getSignature().getName();
		System.out.println("5 (@After) " + nomClasse + "." + nomMethode + "-------------");
		System.out.println("Méthode appelée après exécution");
	}
}
