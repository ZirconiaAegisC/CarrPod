terraform {
  required_version = ">= 1.7"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }

  backend "s3" {
    bucket         = "aegis-citadel-terraform-state"
    key            = "production/terraform.tfstate"
    region         = "us-west-2"
    dynamodb_table = "aegis-citadel-terraform-locks"
    encrypt        = true
  }
}

provider "aws" {
  region = var.aws_region
}
