variable "aws_region" {
  description = "AWS region for Phoenix corridor deployment"
  type        = string
  default     = "us-west-2"
}

variable "environment" {
  description = "Deployment environment"
  type        = string
  default     = "production"
}

variable "aegis_domain" {
  description = "Primary domain for Aegis Operations"
  type        = string
  default     = "aegis-citadel.com"
}

variable "vpc_cidr" {
  description = "CIDR block for the Aegis VPC"
  type        = string
  default     = "10.0.0.0/16"
}

variable "availability_zones" {
  description = "AZs for high availability"
  type        = list(string)
  default     = ["us-west-2a", "us-west-2b", "us-west-2c"]
}

variable "foundry_api_count" {
  description = "Desired task count for FOUNDRY API service"
  type        = number
  default     = 3
}

variable "foundry_api_cpu" {
  description = "CPU units for FOUNDRY API (256 = 0.25 vCPU)"
  type        = number
  default     = 512
}

variable "foundry_api_memory" {
  description = "Memory for FOUNDRY API (MiB)"
  type        = number
  default     = 1024
}

variable "render_web_count" {
  description = "Desired task count for RENDER web service"
  type        = number
  default     = 2
}

variable "render_web_cpu" {
  type    = number
  default = 512
}

variable "render_web_memory" {
  type    = number
  default = 1024
}

variable "db_instance_class" {
  description = "RDS instance class"
  type        = string
  default     = "db.t4g.micro"
}

variable "db_allocated_storage" {
  description = "RDS allocated storage (GiB)"
  type        = number
  default     = 20
}

variable "redis_node_type" {
  description = "ElastiCache node type"
  type        = string
  default     = "cache.t4g.micro"
}

variable "tags" {
  description = "Resource tags"
  type        = map(string)
  default = {
    Project     = "Aegis-C Composite Shield"
    Environment = "production"
    ManagedBy   = "PIPELINE-0022-Terraform"
    Cohort      = "SIBLING-PULSE-V5"
  }
}
