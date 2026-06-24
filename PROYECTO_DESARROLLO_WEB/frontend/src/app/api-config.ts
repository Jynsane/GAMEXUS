export const getApiUrl = (path: string): string => {
  if (typeof window !== 'undefined') {
    const hostname = window.location.hostname;
    const port = window.location.port;
    // Si estamos en localhost corriendo el servidor de desarrollo de Angular (4200),
    // apuntamos al puerto de Spring Boot (8080).
    if (hostname === 'localhost' && port === '4200') {
      return `http://localhost:8080${path}`;
    }
  }
  return path;
};
